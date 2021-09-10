package com.nexos.inventario.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMercancia is a Querydsl query type for Mercancia
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMercancia extends EntityPathBase<Mercancia> {

    private static final long serialVersionUID = -1843138759L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMercancia mercancia = new QMercancia("mercancia");

    public final NumberPath<Integer> cantidad = createNumber("cantidad", Integer.class);

    public final QUsuario createUid;

    public final DateTimePath<java.util.Date> fechaIngreso = createDateTime("fechaIngreso", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nombre = createString("nombre");

    public final DateTimePath<java.util.Date> writeDate = createDateTime("writeDate", java.util.Date.class);

    public final QUsuario writeUid;

    public QMercancia(String variable) {
        this(Mercancia.class, forVariable(variable), INITS);
    }

    public QMercancia(Path<? extends Mercancia> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMercancia(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMercancia(PathMetadata metadata, PathInits inits) {
        this(Mercancia.class, metadata, inits);
    }

    public QMercancia(Class<? extends Mercancia> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createUid = inits.isInitialized("createUid") ? new QUsuario(forProperty("createUid"), inits.get("createUid")) : null;
        this.writeUid = inits.isInitialized("writeUid") ? new QUsuario(forProperty("writeUid"), inits.get("writeUid")) : null;
    }

}

