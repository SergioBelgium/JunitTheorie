package be.vdab.theorie;

public class RepositoryException extends RuntimeException{
    RepositoryException(Exception oorzaak){
        super((oorzaak));
    }
}
