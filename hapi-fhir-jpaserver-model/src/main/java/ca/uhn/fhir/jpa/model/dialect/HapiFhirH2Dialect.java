/*-
 * #%L
 * HAPI FHIR JPA Model
 * %%
 * Copyright (C) 2014 - 2023 Smile CDR, Inc.
 * %%
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
 * #L%
 */
package ca.uhn.fhir.jpa.model.dialect;

import org.hibernate.dialect.DatabaseVersion;
import org.hibernate.dialect.H2Dialect;

/**
 * Dialect for H2 database.
 * Minimum version: 2.2.220
 */
public class HapiFhirH2Dialect extends H2Dialect {

	// FIXME: adjust dialects to not include checks for enums (both string and int)

	/**
	 * Constructor
	 */
	public HapiFhirH2Dialect() {
		super(DatabaseVersion.make(2, 2, 220));

		/*
		 * These mappings are already defined in the super() constructor, but they
		 * will only happen if the dialect can connect to the database and
		 * determine that it's a recent enough version of H2 to support this. This
		 * means that the Maven plugin that does schema generation doesn't add it.
		 * So this dialect forces the use of the right defs.
		 */
		//		registerColumnType(Types.LONGVARCHAR, "character varying");
		//		registerColumnType(Types.BINARY, "binary($l)");
	}
}
