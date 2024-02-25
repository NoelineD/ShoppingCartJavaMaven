package com.ecommerce.servlet;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpUpgradeHandler;
import jakarta.servlet.http.Part;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MockHttpServletRequest implements HttpServletRequest {
    private Map<String, String> parameters = new HashMap<>();
    private MockHttpSession session = new MockHttpSession();

    // Méthode pour définir un paramètre dans la requête simulée
    public void setParameter(String name, String value) {
        parameters.put(name, value);
    }


    @Override
    public String getParameter(String name) {
        return parameters.get(name);
    }

    @Override
    public HttpSession getSession() {
        return session;
    }


	@Override
	public AsyncContext getAsyncContext() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Enumeration<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getContentLength() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public long getContentLengthLong() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DispatcherType getDispatcherType() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getLocalAddr() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getLocalPort() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Enumeration<Locale> getLocales() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Enumeration<String> getParameterNames() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String[] getParameterValues(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getProtocol() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BufferedReader getReader() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getRealPath(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getRemoteAddr() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getRemoteHost() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getRemotePort() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public RequestDispatcher getRequestDispatcher(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getScheme() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getServerPort() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isAsyncStarted() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isAsyncSupported() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void removeAttribute(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setAttribute(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public AsyncContext startAsync() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1) throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String changeSessionId() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getAuthType() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getContextPath() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Cookie[] getCookies() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public long getDateHeader(String name) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getHeader(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Enumeration<String> getHeaderNames() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Enumeration<String> getHeaders(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getIntHeader(String name) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getMethod() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Part getPart(String name) throws IOException, ServletException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Collection<Part> getParts() throws IOException, ServletException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPathInfo() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPathTranslated() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getQueryString() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getRemoteUser() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getRequestURI() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public StringBuffer getRequestURL() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getRequestedSessionId() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getServletPath() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HttpSession getSession(boolean create) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Principal getUserPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isRequestedSessionIdFromCookie() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isRequestedSessionIdFromURL() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isRequestedSessionIdFromUrl() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isRequestedSessionIdValid() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isUserInRole(String role) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void login(String arg0, String arg1) throws ServletException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void logout() throws ServletException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
		// TODO Auto-generated method stub
		return null;
	}


	public void setSession(MockHttpSession session2) {
		// TODO Auto-generated method stub
		
	}

    
}