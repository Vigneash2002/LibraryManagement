/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddEBook;

/**
 *
 * @author nsivaakumaar
 */
public class AddBookBean implements java.io.Serializable{
    private String isbn_number;
    private String book_name;
    private String author_first_name;
    private String author_last_name;
    private String file_path;
    public void setisbn_number(String isbn_number){
        this.isbn_number = isbn_number;
    }
    public String getisbn_number(){
        return isbn_number;
    }
    public void setbook_name(String book_name){
        this.book_name = book_name;
    }
    public String getbook_name(){
        return book_name;
    }
    public void setauthor_first_name(String author_first_name){
        this.author_first_name = author_first_name;
    }
    public String getauthor_first_name(){
        return author_first_name;
    }
    public void setauthor_last_name(String author_last_name){
        this.author_last_name = author_last_name;
    }
    public String getauthor_last_name(){
        return author_last_name;
    }
    public void setfile_path(String file_path){
        this.file_path = file_path;
    }
    public String getfile_path(){
        return file_path;
    }
}

