/*
 * Copyright 2018 Osmium
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kz.osmium.account.util.gson;

import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName("id")
    private final int id;
    @SerializedName("name_f")
    private final String nameF;
    @SerializedName("name_l")
    private final String nameL;
    @SerializedName("patronymic")
    private final String patronymic;
    @SerializedName("gender")
    private final String gender;

    public Account(int id, String nameF, String nameL, String patronymic, String gender) {
        this.id = id;
        this.nameF = nameF;
        this.nameL = nameL;
        this.patronymic = patronymic;
        this.gender = gender;
    }
}
