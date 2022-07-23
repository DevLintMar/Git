package com.lintmar.springboot.repository.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author LintMar
 * @date 2022/7/23
 **/
@Repository
public class RedisTokenRepository implements PersistentTokenRepository {
    private static final String REMEMBER_ME_KEY_PREFIX = "spring:security:remember:";

    @Resource
    private RedisTemplate<Object, Object> template;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        String key = REMEMBER_ME_KEY_PREFIX + "username:" + token.getUsername();
        template.opsForValue().set(key, token.getSeries(), 1, TimeUnit.DAYS);
        this.setToken(token);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        PersistentRememberMeToken token = this.getToken(series);
        if (token != null) {
            this.setToken(new PersistentRememberMeToken(token.getUsername(), series, tokenValue, lastUsed));
        }
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        return this.getToken(seriesId);
    }

    @Override
    public void removeUserTokens(String username) {
        String series = (String) template.opsForValue().get(REMEMBER_ME_KEY_PREFIX + "username:" + username);
        template.delete(REMEMBER_ME_KEY_PREFIX + series);
        template.delete(REMEMBER_ME_KEY_PREFIX + "username:" + username);
    }

    private PersistentRememberMeToken getToken(String series) {
        Map<Object, Object> map = template.opsForHash().entries(REMEMBER_ME_KEY_PREFIX + series);
        if (map.isEmpty()) return null;
        return new PersistentRememberMeToken(
                (String) map.get("username"),
                (String) map.get("series"),
                (String) map.get("tokenValue"),
                new Date(Long.parseLong((String) map.get("date"))));
    }

    private void setToken(PersistentRememberMeToken token) {
        Map<String, String> map = new HashMap<>();
        map.put("username", token.getUsername());
        map.put("series", token.getSeries());
        map.put("tokenValue", token.getTokenValue());
        map.put("date", "" + token.getDate().getTime());
        template.opsForHash().putAll(REMEMBER_ME_KEY_PREFIX + token.getSeries(), map);
        template.expire(REMEMBER_ME_KEY_PREFIX + token.getSeries(), 1, TimeUnit.DAYS);
    }
}
