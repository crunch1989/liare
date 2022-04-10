package com.stevens.liare.security.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stevens.liare.security.model.Usuario;

public class UserPrincipal implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	private Long id;

    private String nombres;
    
    private String apellidoPaterno;
    
    private String apellidoMaterno;
    
    private String codigoOficina;
    
    private String descripcionOficina;    

    private String username;   
    
    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;   
    
    

    public UserPrincipal(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, String codigoOficina,
			String descripcionOficina, String username, String password,String email,
			Collection<? extends GrantedAuthority> authorities) {		
		this.id = id;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.codigoOficina = codigoOficina;
		this.descripcionOficina = descripcionOficina;
		this.username = username;
		this.password = password;
		this.email  = email;
		this.authorities = authorities;
	}	

    public static UserPrincipal build(Usuario user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getAlias())
        ).collect(Collectors.toList());

        return new UserPrincipal(
                user.getIdUsuario(),
                user.getNombres(),
                user.getApellidoPaterno(),
                user.getApellidoMaterno(),
                user.getCodigoOficina(),
                user.getDescripcionOficina(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                authorities
        );
    }

    public Long getId() {
        return id;
    } 

    public String getNombres() {
		return nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public String getCodigoOficina() {
		return codigoOficina;
	}

	public String getDescripcionOficina() {
		return descripcionOficina;
	}	

	public String getEmail() {
		return email;
	}

	@Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrincipal user = (UserPrincipal) o;
        return Objects.equals(id, user.id);
    }
}