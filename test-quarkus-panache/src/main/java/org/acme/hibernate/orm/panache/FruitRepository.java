/*
 *
 * Talkdesk Confidential
 *
 * Copyright (C) Talkdesk Inc. 2020
 *
 * The source code for this program is not published or otherwise divested
 * of its trade secrets, irrespective of what has been deposited with the
 * U.S. Copyright Office. Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 */
package org.acme.hibernate.orm.panache;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FruitRepository implements PanacheRepository<Fruit> {

    public List<Fruit> findStartedBy(String prefix) {
        try(final Stream<Fruit> fruits = streamAll()){
            return fruits.filter(fruit -> fruit.name.startsWith(prefix)).collect(Collectors.toList());
        }
    }
}
