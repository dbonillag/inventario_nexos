package com.nexos.inventario.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCargo is a Querydsl query type for Cargo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCargo extends EntityPathBase<Cargo> {

    private static final long serialVersionUID = -1951176784L;

    public static final QCargo cargo = new QCargo("cargo");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nombre = createString("nombre");

    public QCargo(String variable) {
        super(Cargo.class, forVariable(variable));
    }

    public QCargo(Path<? extends Cargo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCargo(PathMetadata metadata) {
        super(Cargo.class, metadata);
    }

}

