/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.model

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.validation.constraints.NotEmpty

/**
 * Simple JavaBean domain object representing an person.
 *
 * @author Ken Krebs
 * @author Antoine Rey
 */
@MappedSuperclass
open class Person : BaseEntity() {

    @Column(name = "first_name") @NotEmpty var firstName = ""

    @Column(name = "middle_name") var middleName: String? = null

    @Column(name = "last_name") @NotEmpty var lastName = ""

    fun fullName(): String {
        return if (middleName != null) {
            "$firstName ${middleName?.let { it.firstOrNull()?.plus(".") } ?: ""} $lastName"
        } else {
            "$firstName $lastName"
        }
    }
}
