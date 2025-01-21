package com.gpolicene.dslist.projections;

public interface GameMinProjection {

    // Na projection, temos que colocar uma função para cada coluna que a query está retornando.*/
    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();

}
