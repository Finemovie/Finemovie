package templates.utils;

import org.springframework.security.core.Authentication;

import com.green.Finemovie.domain.entity.MemberDetails;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenUtils {

    public static long extractMemberNo(Authentication auth) {
        long result = 0L;
        try {
            result = ( (MemberDetails) auth.getPrincipal() ).getMemNo();
        } catch (Exception e) {
            log.debug("Authentication object error", e);
        }
        return result;
    }
}
