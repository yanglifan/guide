package com.github.navi.core.matcher;

import com.github.navi.core.MatchResult;
import com.github.navi.core.MatcherType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@MatcherType(processor = EqualsMatcher.Processor.class)
public @interface EqualsMatcher {
	String propertyPath();

	String[] expectValue();

	class Processor extends OnePropertyMatcherProcessor<EqualsMatcher> {

		@Override
		protected String getPropertyPath(EqualsMatcher matcherAnnotation) {
			return matcherAnnotation.propertyPath();
		}

		@Override
		protected MatchResult doProcess(Object request, EqualsMatcher matcherAnnotation) {
			List<String> expectValueList = Arrays.asList(matcherAnnotation.expectValue());
			boolean isContains = expectValueList.contains(request.toString());
			return isContains ? MatchResult.ACCEPT : MatchResult.REJECT;
		}
	}
}
