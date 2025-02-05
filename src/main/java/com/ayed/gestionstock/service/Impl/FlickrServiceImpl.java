package com.ayed.gestionstock.service.Impl;

import com.ayed.gestionstock.service.FlickrService;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
@Service @Slf4j
public class FlickrServiceImpl implements FlickrService {

    @Value("${flickr.apiKey}")
    private String apiKey;
    @Value("${flickr.apiSecret}")
    private String apiSecret;
    @Value("${flickr.appKey}")
    private String appKey;
    @Value("${flickr.appSecret}")
    private String appSecret;
    private Flickr flickr;

    public FlickrServiceImpl(Flickr flickr) {
        this.flickr = flickr;
    }

    @Override
    public String savePhoto(InputStream photo, String titre) throws FlickrException {

        UploadMetaData uploadMetaData=new UploadMetaData();
        uploadMetaData.setTitle(titre);

        String photoId=flickr.getUploader().upload(photo,uploadMetaData);


        return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
    }

}
