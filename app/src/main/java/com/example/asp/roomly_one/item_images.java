package com.example.asp.roomly_one;

public class item_images {


    public String name;
    public String image;
    public String price;

    public  item_images()
    {}
    public item_images(String name, String price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }




    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }


    public void setName(String name )
    {

        this.name =name;
    }


    public void setPrice (String price ){

        this.price=price;
    }

    public void setImage(String image){

        this.image =image;
    }

}