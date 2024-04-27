package edu.mui.cs489.reachnou.questify.filter;

import edu.mui.cs489.reachnou.questify.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null){
            filterChain.doFilter(request, response);
            return;
        }

        String token = authorizationHeader.split(" ")[1].trim();
        boolean isTokenValid = jwtTokenUtil.validateToken(token);
        if (!isTokenValid){
            filterChain.doFilter(request, response);
            return;
        }

        Claims claims = jwtTokenUtil.parseClaims(token);
        String email = claims.getSubject();

        List<Map<String, Object>> mapObj = (ArrayList<Map<String, Object>>) claims.get("ROLE");

        Set<GrantedAuthority> authorities = mapObj == null ? Collections.emptySet() :
                mapObj.stream()
                .map(obj -> new SimpleGrantedAuthority(obj.get("title").toString()))
                .collect(Collectors.toSet());

        Authentication authentication = new UsernamePasswordAuthenticationToken(email, null, authorities);
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

        filterChain.doFilter(request, response);
    }
}
