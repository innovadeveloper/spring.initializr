/*
 * Copyright 2012-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.initializr.generator.language.java;

import io.spring.initializr.generator.language.Annotatable;
import io.spring.initializr.generator.language.AnnotationContainer;

/**
 * Declaration of a field written in Java.
 *
 * @author Matt Berteaux
 */
public final class JavaFieldDeclaration implements Annotatable {

	private final AnnotationContainer annotations = new AnnotationContainer();

	private final int modifiers;

	private final String name;

	private final String returnType;

	private final Object value;

	private final boolean initialized;

	private JavaFieldDeclaration(Builder builder) {
		this.modifiers = builder.modifiers;
		this.name = builder.name;
		this.returnType = builder.returnType;
		this.value = builder.value;
		this.initialized = builder.initialized;
	}

	public static Builder field(String name) {
		return new Builder(name);
	}

	@Override
	public AnnotationContainer annotations() {
		return this.annotations;
	}

	public int getModifiers() {
		return this.modifiers;
	}

	public String getName() {
		return this.name;
	}

	public String getReturnType() {
		return this.returnType;
	}

	public Object getValue() {
		return this.value;
	}

	public boolean isInitialized() {
		return this.initialized;
	}

	/**
	 * Builder for creating a {@link JavaFieldDeclaration}.
	 */
	public static final class Builder {

		private final String name;

		private String returnType;

		private int modifiers;

		private Object value;

		private boolean initialized;

		private Builder(String name) {
			this.name = name;
		}

		public Builder modifiers(int modifiers) {
			this.modifiers = modifiers;
			return this;
		}

		public Builder value(Object value) {
			this.value = value;
			this.initialized = true;
			return this;
		}

		public JavaFieldDeclaration returning(String returnType) {
			this.returnType = returnType;
			return new JavaFieldDeclaration(this);
		}

	}

}
