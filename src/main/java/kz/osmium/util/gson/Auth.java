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

package kz.osmium.util.gson;

import com.google.gson.annotations.SerializedName;

public class Auth {
    @SerializedName("id")
    private final int id;
    @SerializedName("name_f")
    private final String nameFId;
    @SerializedName("name_l")
    private final String nameLId;
    @SerializedName("patronymic")
    private final String patronymicId;
    @SerializedName("gender")
    private final String genderId;
    @SerializedName("iin")
    private final long iin;

    public Auth(int id, String nameFId, String nameLId, String patronymicId, String genderId, long iin) {
        this.id = id;
        this.nameFId = nameFId;
        this.nameLId = nameLId;
        this.patronymicId = patronymicId;
        this.genderId = genderId;
        this.iin = iin;
    }
}
