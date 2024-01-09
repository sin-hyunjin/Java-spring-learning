package com.example.demo.common.exception

import com.example.demo.common.dto.BaseResponse
import com.example.demo.common.status.ResultCode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * `@RestControllerAdvice`를 사용하여 컨트롤러에서 발생하는 예외들을 처리하는 클래스
 */
@RestControllerAdvice
class CustomExceptionHandler {

    /**
     * `MethodArgumentNotValidException` 예외를 처리하는 메서드
     * 주로 입력값의 유효성 검사에서 발생한 예외를 처리함
     * 바인딩된 결과에서 필드 에러를 추출하고, 에러 메시지를 맵에 담아 응답함
     */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    protected fun handleValidationExceptions(ex: MethodArgumentNotValidException):
            ResponseEntity<BaseResponse<Map<String, String>>> {
        val errors = mutableMapOf<String, String>()
        ex.bindingResult.allErrors.forEach { error ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.getDefaultMessage()
            errors[fieldName] = errorMessage ?: "Not Exception Message"
        }
        return ResponseEntity(BaseResponse(
            ResultCode.ERROR.name,
            errors,
            ResultCode.ERROR.msg
        ), HttpStatus.BAD_REQUEST)
    }

    /**
     * `InvalidInputException` 예외를 처리하는 메서드
     * 사용자 정의 예외로, 필드 이름과 에러 메시지를 응답함
     */
    @ExceptionHandler(InvalidInputException::class)
    protected fun invalidInputException(ex: InvalidInputException):
            ResponseEntity<BaseResponse<Map<String, String>>> {
        val errors = mapOf(ex.fieldName to (ex.message ?: "Not Exception Message"))
        return ResponseEntity(BaseResponse(
            ResultCode.ERROR.name,
            errors,
            ResultCode.ERROR.msg
        ), HttpStatus.BAD_REQUEST)
    }

    /**
     * 그 외 모든 예외를 처리하는 기본 메서드
     * 예외 메시지를 맵에 담아 응답함
     */
    @ExceptionHandler(Exception::class)
    protected fun defaultException(ex: Exception):
            ResponseEntity<BaseResponse<Map<String, String>>> {
        val errors = mapOf(" " to (ex.message ?: "Not Exception Message"))
        return ResponseEntity(BaseResponse(
            ResultCode.ERROR.name,
            errors,
            ResultCode.ERROR.msg
        ), HttpStatus.BAD_REQUEST)
    }
    @ExceptionHandler(BadCredentialsException::class)
    protected fun badCredentialsException(ex: BadCredentialsException):
            ResponseEntity<BaseResponse<Map<String, String>>> {
        val errors = mapOf("로그인 실패" to "아이디 혹은 비밀번호를 다시 확인하세요.")
        return ResponseEntity(BaseResponse(
            ResultCode.ERROR.name,
            errors,
            ResultCode.ERROR.msg
        ), HttpStatus.BAD_REQUEST)
    }
}
