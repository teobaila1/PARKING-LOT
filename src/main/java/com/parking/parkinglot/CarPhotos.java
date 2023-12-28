package com.parking.parkinglot;

import com.parking.parkinglot.common.CarPhotoDto;
import com.parking.parkinglot.ejb.CarsBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet(name = "CarPhotos", value = "/CarPhotos")
public class CarPhotos extends HttpServlet {

    @Inject
    CarsBean carsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer carId = Integer.parseInt(request.getParameter("id"));
        CarPhotoDto photo = carsBean.findPhotoByCarId(carId);
        if(photo != null) {
            response.setContentType(photo.getFileType());
            response.setContentLength(photo.getFileContent().length);
            response.getOutputStream().write(photo.getFileContent());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); //ERROR 404
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}