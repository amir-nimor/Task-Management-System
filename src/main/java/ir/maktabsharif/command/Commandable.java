package ir.maktabsharif.command;

public interface Commandable <A,Q,S>{


    public A DtoRequestToDao (Q q);

    public S DaoToDtoResponse(A a);

}
