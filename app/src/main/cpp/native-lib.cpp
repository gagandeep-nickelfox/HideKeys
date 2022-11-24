//
// Created by Gagandeep-Nickelfox on 26/09/22.
//

#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_gagandeep_hidekeys_any_Keys_getApiKey(JNIEnv *env, jobject thiz) {
    std::string key = "mky_maps_api_key";
    return env->NewStringUTF(key.c_str());
}