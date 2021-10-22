package dorres.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBootBoard is a Querydsl query type for BootBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBootBoard extends EntityPathBase<BootBoard> {

    private static final long serialVersionUID = -1189316842L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBootBoard bootBoard = new QBootBoard("bootBoard");

    public final NumberPath<Long> cnt = createNumber("cnt", Long.class);

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> createDate = createDateTime("createDate", java.util.Date.class);

    public final QMember member;

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath title = createString("title");

    public QBootBoard(String variable) {
        this(BootBoard.class, forVariable(variable), INITS);
    }

    public QBootBoard(Path<? extends BootBoard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBootBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBootBoard(PathMetadata metadata, PathInits inits) {
        this(BootBoard.class, metadata, inits);
    }

    public QBootBoard(Class<? extends BootBoard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

