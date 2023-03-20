
package com.portfolioAP.tpfinal.seguridad.jwt;

import com.portfolioAP.tpfinal.seguridad.servicio.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//es la mas importante, se ejecuta por cada petición y ve la validez y permite el acceso al recurso
public class JwtTokenFilter extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
         try{
             String token = getToken(request);
             if (token != null && jwtProvider.validateToken(token)) {
                 //obtenemos nombre del usuario
                 String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                 //obtenemos datos del usuario
                 UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);
                 //para autenticar al usuario
                 UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                 //seteamos la autenticación para asignarle ese usuario
                 SecurityContextHolder.getContext().setAuthentication(auth);
             }
         } catch (Exception e){
             logger.error("Fallo en el método doFilter");
         }
         filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer"))
            return header.replace("Bearer ", "");
        return null;
    }
}
