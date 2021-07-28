package jp.ac.isc.cloud;

import java.io.*;

import javax.servlet.*;

public class EncodingFilter implements Filter {
	private String encoding = null;

	@Override
	//web.xmlに定義されたencoding情報を取得
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
	}

	@Override
	//ブラウザから送信された情報をencodingで指定された文字コードに設定する
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain)
			throws IOException, ServletException {
		//リクエストの文字コードを指定する
		request.setCharacterEncoding(encoding);
		//フィルタを実行する
		chain.doFilter(request, response);
	}

	@Override
	//フィルタの終了処理をする
	public void destroy() {
		encoding = null;
	}



}
