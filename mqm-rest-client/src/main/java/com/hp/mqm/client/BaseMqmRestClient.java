package com.hp.mqm.client;

import com.hp.mqm.client.exception.SharedSpaceNotExistException;

public interface BaseMqmRestClient {

    /**
     * Tries login and when it passes it tries to connect to project.
     * @throws com.hp.mqm.client.exception.AuthenticationException when authentication fails
     * @throws com.hp.mqm.client.exception.SessionCreationException when session creation fails
     * @throws SharedSpaceNotExistException when shared space does not exist
     * @throws com.hp.mqm.client.exception.LoginErrorException in case of IO error or error in the HTTP protocol
     * during login (authentication or session creation)
     * @throws com.hp.mqm.client.exception.RequestErrorException in case of IO error or error in the HTTP protocol
     * during either authentication or session creation or project, domain check
     * (for authentication and session creation issues {@link com.hp.mqm.client.exception.LoginErrorException} as special
     * case of RequestErrorException is thrown)
     */
    void tryToConnectSharedSpace();

    /**
     * This method should be called when client is not needed or it should not be used for a long time. It performs
     * logout and releases all system resources if it is necessary. After invocation of {@link #release()} you can still
     * invoke any client method (but client will need to do authentication, create session, etc.).
     */
    void release();

    /**
     * Equivalent to @link #release}, except any exceptions are ignored. Exceptions are logged only.
     */
    void releaseQuietly();
}
