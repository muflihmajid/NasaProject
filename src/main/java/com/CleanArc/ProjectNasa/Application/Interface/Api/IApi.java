package com.CleanArc.ProjectNasa.Application.Interface.Api;

import org.springframework.stereotype.Service;

@Service
public interface IApi {
    String GetApiCall(String url);
}
