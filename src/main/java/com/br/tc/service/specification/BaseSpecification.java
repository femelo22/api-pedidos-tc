package com.br.tc.service.specification;

import org.springframework.data.jpa.domain.Specification;

public abstract  class BaseSpecification<T, U> {

	private final String wildcard = "%";

	public abstract Specification<T> getFilter(U filter);

	protected String containsLowerCase(String searchField) {
		return wildcard + searchField.toLowerCase() + wildcard;
	}

	protected String lowerCase(String searchField) {
		return searchField.toLowerCase();
	}

}
