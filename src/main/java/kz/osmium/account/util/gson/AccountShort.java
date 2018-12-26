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
import kz.osmium.util.DataConfig;

public class AccountShort {
    @SerializedName(DataConfig.DB_ACCOUNT_SHORT_ID)
    private final int id;
    @SerializedName(DataConfig.DB_ACCOUNT_SHORT_NAME_F)
    private final String nameF;
    @SerializedName(DataConfig.DB_ACCOUNT_SHORT_NAME_L)
    private final String nameL;
    @SerializedName(DataConfig.DB_ACCOUNT_SHORT_PATRONYMIC)
    private final String patronymic;
    @SerializedName(DataConfig.DB_ACCOUNT_SHORT_GENDER)
    private final String gender;

    public AccountShort(int id, String nameF, String nameL, String patronymic, String gender) {
        this.id = id;
        this.nameF = nameF;
        this.nameL = nameL;
        this.patronymic = patronymic;
        this.gender = gender;
    }
}
