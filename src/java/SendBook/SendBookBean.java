/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SendBook;

/**
 *
 * @author nsivaakumaar
 */
public class SendBookBean {
    private String isbn_number;
    private String book_name;
    private String file_path;
    private String email;
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
    public void setfile_path(String file_path){
        this.file_path = file_path;
    }
    public String getfile_path(){
        return file_path;
    }
    public void setemail(String email){
        this.email = email;
    }
    public String getemail(){
        return email;
    }
}
