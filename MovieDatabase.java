public class MovieDatabase {
    BST bst;
    public MovieDatabase(){
     bst= new BST();;
    }
    public void addMovie(String movieTitle,String directoryFirstName,String directorLastName, int releaseDay,int releaseMonth,int releaseYear){
        Movie newMovie = new Movie(movieTitle,new CustomDate(releaseDay,releaseMonth,releaseYear),directoryFirstName,directorLastName);
        Movie found =(Movie)bst.findMovie(movieTitle);
        if(found==null){
            bst.addNode(newMovie);
            System.out.printf("INFO: Movie %s has been added\n",movieTitle);
        }
        else{
            found.setCastList(newMovie.getCastList());
            found.setDate(newMovie.getDate());
            found.setFirstName(newMovie.getFirstName());
            found.setLastName(newMovie.getLastName());
            System.out.printf("INFO: Movie %s overwritten\n",movieTitle);
        }
    }
    public void removeMovie(String movieTitle){
        TreeNode movie = bst.findMovie(movieTitle);
        if(movie!=null){
            bst.deleteNode(movie);
            System.out.printf("INFO: Movie %s has been removed\n",movieTitle);
        }
        else System.out.printf("INFO: Movie %s does not exist\n",movieTitle);
    }
    public void addActor(String movieTitle,String actorFirstName,String actorLastName,String actorRole){
        Cast cast = new Cast(actorFirstName,actorLastName,actorRole);
        Movie movie = (Movie)bst.findMovie(movieTitle);
        if(movie!=null){
            Cast exists = (Cast)movie.getCastList().findActor(actorFirstName,actorLastName);
            if(exists==null){
                movie.addActor(cast);
                System.out.printf("INFO: %s %s has been added to the movie %s\n",actorFirstName,actorLastName,movieTitle);
            }
            else{
                exists.setRole(actorRole);
                System.out.printf("INFO: Cast %s %s overwritten\n",actorFirstName,actorLastName);
            }
        }
        else System.out.printf("INFO: Movie %s does not exist\n",movieTitle);
    }
    public void removeActor(String movieTitle,String actorFirstName,String actorLastName){
        Movie movie = (Movie)bst.findMovie(movieTitle);
        Cast cast = (Cast)movie.getCastList().findActor(actorFirstName,actorLastName);
        if(cast!=null){
            movie.getCastList().deleteNode(cast);
            System.out.printf("INFO: %s %s has been removed from the movie %s\n",actorFirstName,actorLastName,movieTitle);
        }
        else System.out.printf("INFO: %s %s does not exist\n",actorFirstName,actorLastName);
        System.out.println();
    }
    public void showAllMovies(){
        System.out.println();
        if(bst.root==null){
            System.out.println("---none---");
        }
        else{
            bst.printInOrder();
        }
        System.out.println();
    }
    public void showMovie(String movieTitle){
        Movie movie = (Movie)bst.findMovie(movieTitle);
        if(movie!=null){
            CustomDate movieDate = movie.getDate();
            System.out.printf("%s\n%d/%d/%d\n%s %s\n",movieTitle,movieDate.getDay(),movieDate.getMonth(),movieDate.getYear(),movie.getFirstName(),movie.getLastName());
            BSTIterator castIterator = new BSTIterator(movie.getCastList().root);
            while(castIterator.hasNext()){
                Cast cast = (Cast)castIterator.next();
                System.out.printf("%s %s, %s\n",cast.getFirstName(),cast.getLastName(),cast.getRole());
            }
        }
        else System.out.printf("Movie could not found: %s\n",movieTitle);
        System.out.println();
    }
    public void showActorRoles(String actorFirstNAme,String actorLastName){
        BSTIterator iterator = new BSTIterator(bst.root);
        System.out.printf("%s %s\n",actorFirstNAme,actorLastName);
        while (iterator.hasNext()){
            Movie movie = (Movie)iterator.next();
            BSTIterator actorIterator = new BSTIterator(movie.getCastList().root);
            while (actorIterator.hasNext()){
                Cast cast = (Cast)actorIterator.next();
                if (cast.getFirstName().equalsIgnoreCase(actorFirstNAme)&&cast.getLastName().equalsIgnoreCase(actorLastName)){
                    System.out.printf("%s, %s, %d\n",cast.getRole(),movie.getTitle(),movie.getDate().getYear());
                }
            }
        }
        System.out.println();
    }
    public void showDirectorMovies(String directorFirstName,String directorLastName){
        BSTIterator iterator = new BSTIterator(bst.root);
        System.out.printf("%s %s\n",directorFirstName,directorLastName);
        while (iterator.hasNext()){
            Movie movie = (Movie)iterator.next();
            if (movie.getFirstName().equalsIgnoreCase(directorFirstName)&&movie.getLastName().equalsIgnoreCase(directorLastName)){
                System.out.printf("%s, %d/%d/%d\n",movie.getTitle(),movie.getDate().getDay(),movie.getDate().getMonth(),movie.getDate().getYear());
            }
        }
        System.out.println();
    }
    public void showMovies(int releaseYear){
        System.out.printf("%d\n",releaseYear);
        BSTIterator iterator = new BSTIterator(bst.root);
        while (iterator.hasNext()){
            Movie movie = (Movie)iterator.next();
            if(movie.getDate().getYear()==releaseYear){
                System.out.printf("%s, %s %s, %d/%d\n",movie.getTitle(),movie.getFirstName(),movie.getLastName(),movie.getDate().getDay(),movie.getDate().getMonth());
            }
        }
        System.out.println();
    }
    public void showMovies(int startYear,int endYear){
        System.out.printf("Released between %d - %d\n",startYear,endYear);
        BSTIterator iterator = new BSTIterator(bst.root);
        while (iterator.hasNext()){
            Movie movie = (Movie)iterator.next();
            if(movie.getDate().getYear()>=startYear&&movie.getDate().getYear()<=endYear){
                System.out.printf("%s, %s %s, %d \n",movie.getTitle(),movie.getFirstName(),movie.getLastName(),movie.getDate().getYear());
            }
        }
        System.out.println();
    }
}
