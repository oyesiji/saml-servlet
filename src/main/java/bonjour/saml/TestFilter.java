package bonjour.saml;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import bonjour.saml.SAMLUtil.SAMLUserDetail;

public class TestFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {


  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    String samlResponse = request.getParameter("SAMLResponse");
    if (samlResponse != null) {
      SAMLUtil samlUtil = new SAMLUtil();
      SAMLUserDetail samlUserDetail = samlUtil.parseSamltoObject(samlResponse);
      Map<String, Object> tempMap = samlUserDetail.getAttributes();
      Set<String> keyMap = tempMap.keySet();
      for (String currentKey : keyMap) {
        System.out.println("#################" + currentKey);
        System.out.println("#################" + tempMap.get(currentKey));
      }



    }



    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {


  }

}
