public abstract class Middleware {
    private Middleware next;

    /*
    * Build chain of Middlewares
    * */
    public static Middleware link(Middleware first, Middleware... chain){
        var head = first;
        for(Middleware nextInChain : chain){
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract boolean check(String email, String password);

    protected boolean checkNext(String email, String password){
        if(next == null)
            return true;
        return next.checkNext(email, password);
    }

}
