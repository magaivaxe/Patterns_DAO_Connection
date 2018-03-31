
package datas;

public class Clients
{
    //Fields
    private int id_client;
    private String nom_client;
    private String cell_client;
    private String email_client;
    
    //Constructors =========================================
    public Clients()
    {
    }

    public Clients(int id_client, String nom_client, String cell_client, String email_client)
    {
        this.id_client = id_client;
        this.nom_client = nom_client;
        this.cell_client = cell_client;
        this.email_client = email_client;
    }
    
    //Setters and getters ==================================
    public int getId_client()
    {
        return id_client;
    }

    public void setId_client(int id_client)
    {
        this.id_client = id_client;
    }

    public String getNom_client()
    {
        return nom_client;
    }

    public void setNom_client(String nom_client)
    {
        this.nom_client = nom_client;
    }

    public String getCell_client()
    {
        return cell_client;
    }

    public void setCell_client(String cell_client)
    {
        this.cell_client = cell_client;
    }

    public String getEmail_client()
    {
        return email_client;
    }

    public void setEmail_client(String email_client)
    {
        this.email_client = email_client;
    }
    
    //ToString =============================================
    @Override
    public String toString()
    {
        return "Clients{" 
                + "id_client=" + id_client + ","
                + " nom_client=" + nom_client + ","
                + " cell_client=" + cell_client + ","
                + " email_client=" + email_client + '}';
    }
    
    
    
    
}
