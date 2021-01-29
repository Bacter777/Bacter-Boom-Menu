package com.bacter.boommenu.wallpaper;

public class customItems
{
    String url;
    String name;
    public customItems(String name2,String url2)
    {
        this.url = url2;
        this.name = name2;
    }
    public String getUrl()
    {
        return this.url;
    }
    public void setUrl(String url2)
    {
        this.url = url2;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name2)
    {
        this.name = name2;
    }
}
