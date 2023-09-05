/*
 * Copyright 2002-2020 the original author or authors.
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

package org.springframework.core.type.classreading;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.asm.Opcodes;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.lang.Nullable;

/**
 * {@link AnnotationMetadata} created from a
 * {@link SimpleAnnotationMetadataReadingVisitor}.
 *
 * @author Phillip Webb
 * @since 5.2
 */
/*xxx: 简易注解元数据 */
final class SimpleAnnotationMetadata implements AnnotationMetadata {

	/*xxx: 类名称 */
	private final String className;

	/*xxx: 可见标志 */
	private final int access;

	@Nullable
	/*xxx: 封闭类名*/
	private final String enclosingClassName;

	@Nullable
	/*xxx: 超类名称*/
	private final String superClassName;

	/*xxx: 是否是静态内部类*/
	private final boolean independentInnerClass;

	/*xxx: 接口名称数组*/
	private final String[] interfaceNames;

	/*xxx: 成员类型数组*/
	private final String[] memberClassNames;

	/*xxx: 方法元数据数组*/
	private final MethodMetadata[] annotatedMethods;

	/*xxx: 融合注解*/
	private final MergedAnnotations annotations;

	@Nullable
	/*xxx: 注解类型名称集合*/
	private Set<String> annotationTypes;


	SimpleAnnotationMetadata(String className, int access, @Nullable String enclosingClassName,
			@Nullable String superClassName, boolean independentInnerClass, String[] interfaceNames,
			String[] memberClassNames, MethodMetadata[] annotatedMethods, MergedAnnotations annotations) {

		this.className = className;
		this.access = access;
		this.enclosingClassName = enclosingClassName;
		this.superClassName = superClassName;
		this.independentInnerClass = independentInnerClass;
		this.interfaceNames = interfaceNames;
		this.memberClassNames = memberClassNames;
		this.annotatedMethods = annotatedMethods;
		this.annotations = annotations;
	}

	@Override
	public String getClassName() {
		return this.className;
	}

	@Override
	public boolean isInterface() {
		return (this.access & Opcodes.ACC_INTERFACE) != 0;
	}

	@Override
	public boolean isAnnotation() {
		return (this.access & Opcodes.ACC_ANNOTATION) != 0;
	}

	@Override
	public boolean isAbstract() {
		return (this.access & Opcodes.ACC_ABSTRACT) != 0;
	}

	@Override
	public boolean isFinal() {
		return (this.access & Opcodes.ACC_FINAL) != 0;
	}

	@Override
	public boolean isIndependent() {
		return (this.enclosingClassName == null || this.independentInnerClass);
	}

	@Override
	@Nullable
	public String getEnclosingClassName() {
		return this.enclosingClassName;
	}

	@Override
	@Nullable
	public String getSuperClassName() {
		return this.superClassName;
	}

	@Override
	public String[] getInterfaceNames() {
		return this.interfaceNames.clone();
	}

	@Override
	public String[] getMemberClassNames() {
		return this.memberClassNames.clone();
	}

	@Override
	public Set<String> getAnnotationTypes() {
		Set<String> annotationTypes = this.annotationTypes;
		if (annotationTypes == null) {
			annotationTypes = Collections.unmodifiableSet(
					AnnotationMetadata.super.getAnnotationTypes());
			this.annotationTypes = annotationTypes;
		}
		return annotationTypes;
	}

	@Override
	public Set<MethodMetadata> getAnnotatedMethods(String annotationName) {
		Set<MethodMetadata> annotatedMethods = null;
		for (MethodMetadata annotatedMethod : this.annotatedMethods) {
			if (annotatedMethod.isAnnotated(annotationName)) {
				if (annotatedMethods == null) {
					annotatedMethods = new LinkedHashSet<>(4);
				}
				annotatedMethods.add(annotatedMethod);
			}
		}
		return annotatedMethods != null ? annotatedMethods : Collections.emptySet();
	}

	@Override
	public MergedAnnotations getAnnotations() {
		return this.annotations;
	}

}