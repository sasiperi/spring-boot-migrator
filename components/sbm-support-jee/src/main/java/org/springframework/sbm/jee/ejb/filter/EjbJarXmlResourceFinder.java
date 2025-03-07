/*
 * Copyright 2021 - 2022 the original author or authors.
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
package org.springframework.sbm.jee.ejb.filter;

import org.springframework.sbm.jee.ejb.api.EjbJarXml;
import org.springframework.sbm.project.resource.ProjectResourceSet;
import org.springframework.sbm.project.resource.filter.ProjectResourceFinder;

import java.util.Optional;

public class EjbJarXmlResourceFinder implements ProjectResourceFinder<Optional<EjbJarXml>> {

    private static final String EJB_JAR_XML = "ejb-jar.xml";

    @Override
    public Optional<EjbJarXml> apply(ProjectResourceSet projectResourceSet) {
        return projectResourceSet.stream()
                .filter(r -> EjbJarXml.class.isAssignableFrom(r.getClass()))
                .map(EjbJarXml.class::cast)
                .findFirst();
    }
}
