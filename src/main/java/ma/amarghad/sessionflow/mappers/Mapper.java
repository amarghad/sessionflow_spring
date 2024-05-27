package ma.amarghad.sessionflow.mappers;

public interface Mapper<T, U> {
    U toDto(T entity);
    T toEntity(U dto);
}
