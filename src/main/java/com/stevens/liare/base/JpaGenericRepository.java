package com.stevens.liare.base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public abstract class JpaGenericRepository{	

	@PersistenceContext
	EntityManager entityManager;
		

	public EntityManager createEntityManager() {
		return entityManager;
	}

}
