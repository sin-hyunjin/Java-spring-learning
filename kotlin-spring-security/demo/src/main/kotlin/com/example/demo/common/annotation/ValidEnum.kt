package com.example.demo.common.annotation

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass

/**
 * Enum 값이 유효한지 검증하는 커스텀 어노테이션입니다.
 *
 * @property message 유효하지 않은 경우에 표시할 메시지
 * @property groups 사용자가 그룹화할 수 있는 그룹 클래스 배열
 * @property payload 페이로드 타입의 배열
 * @property enumClass 검증할 Enum 클래스
 */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [ValidEnumValidator::class])
annotation class ValidEnum(
    val message: String = "유효하지 않은 열거형 값입니다.",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val enumClass: KClass<out Enum<*>>
)

/**
 * [ValidEnum] 어노테이션의 유효성을 검사하는 Validator 클래스입니다.
 */
class ValidEnumValidator : ConstraintValidator<ValidEnum, Any> {
    private lateinit var enumValues: Array<out Enum<*>>

    /**
     * Validator 초기화 메서드.
     * 검증할 Enum 클래스의 상수 배열을 초기화합니다.
     *
     * @param annotation 어노테이션 정보
     */
    override fun initialize(annotation: ValidEnum) {
        enumValues = annotation.enumClass.java.enumConstants
    }

    /**
     * 값의 유효성을 검사하는 메서드.
     *
     * @param value 검사 대상 값
     * @param context 제약 조건의 컨텍스트
     * @return 값이 유효하면 true, 그렇지 않으면 false
     */
    override fun isValid(
        value: Any?,
        context: ConstraintValidatorContext
    ): Boolean {
        if (value == null) {
            return true
        }
        return enumValues.any { it.name == value.toString() }
    }
}
