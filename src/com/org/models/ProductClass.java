
package com.org.models;

/**
 *
 * @author EgronGT
 */
public class ProductClass  {
   private int id;
   private String name;
   private float price;
   private String addDate;
   private byte[] picture;
   
   public ProductClass (int pid, String pname, float pprice, String pAddDate, byte[] pimg)
   {
       this.id = pid;
       this.name =pname;
       this.price =pprice;
       this.addDate = pAddDate;
       this.picture = pimg;
       
   }
   public int getId()
   {
       return id;
   }
   public String getName()
   {
       return name;
   }
   public float getPrice()
   {
       return price;
       
   }
   public String getAddDate()
   {
       return addDate;
   }
   public byte[] getImage()
   {
       return picture;
   }
}
