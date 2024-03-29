package com.ecommerce.servlet;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Locale;

public class MockHttpServletResponse implements HttpServletResponse {
    private StringWriter stringWriter = new StringWriter();
    private PrintWriter writer = new PrintWriter(stringWriter);

    // Méthode pour récupérer le contenu de la réponse simulée
    public String getContentAsString() {
        return stringWriter.toString();
    }


    @Override
    public PrintWriter getWriter() {
        return writer;
    }


	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void resetBuffer() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setBufferSize(int arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setCharacterEncoding(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setContentLength(int arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setContentLengthLong(long arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setContentType(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setLocale(Locale arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addCookie(Cookie cookie) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addDateHeader(String arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addHeader(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addIntHeader(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean containsHeader(String name) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String encodeRedirectURL(String url) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String encodeRedirectUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String encodeURL(String url) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String encodeUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getHeader(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Collection<String> getHeaderNames() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Collection<String> getHeaders(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getStatus() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void sendError(int sc) throws IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sendError(int arg0, String arg1) throws IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sendRedirect(String location) throws IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setDateHeader(String arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setHeader(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setIntHeader(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setStatus(int sc) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setStatus(int arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}


	}

    
}