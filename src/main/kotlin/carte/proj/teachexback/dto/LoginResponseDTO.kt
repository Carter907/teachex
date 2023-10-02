package carte.proj.teachexback.dto

import carte.proj.teachexback.model.User


data class LoginResponseDTO(val user: User?,val jwt: String) {
}