/* Generated By:JJTree: Do not edit this line. OExpression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import java.util.Map;

public class OExpression extends SimpleNode {

  protected Boolean singleQuotes;
  protected Boolean doubleQuotes;

  public OExpression(int id) {
    super(id);
  }

  public OExpression(OrientSql p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  public Object createExecutorFilter() {

    // TODO create an interface for this;

    if (value instanceof ORid) {
      return null;// TODO
    } else if (value instanceof OInputParameter) {
      return null;// TODO
    } else if (value instanceof OMathExpression) {
      return ((OMathExpression) value).createExecutorFilter();
    } else if (value instanceof OJson) {
      return null;// TODO
    } else if (value instanceof String) {
      return value;
    } else if (value instanceof Number) {
      return value;
    }

    return value;

  }

  public String getDefaultAlias() {

    if (value instanceof String) {
      return (String) value;
    }
    // TODO create an interface for this;

    // if (value instanceof ORid) {
    // return null;// TODO
    // } else if (value instanceof OInputParameter) {
    // return null;// TODO
    // } else if (value instanceof OMathExpression) {
    // return null;// TODO
    // } else if (value instanceof OJson) {
    // return null;// TODO
    // }

    return "" + value;

  }

  @Override
  public String toString() {
    if (value == null) {
      return "null";
    } else if (value instanceof SimpleNode) {
      return value.toString();
    } else if (value instanceof String) {
      if (Boolean.TRUE.equals(singleQuotes)) {
        return "'" + encodeSingle((String)value)+ "'";
      }
      return "\"" + encode((String)value) + "\"";
    } else {
      return "" + value;
    }
  }

  public static String encode(String s) {
    StringBuilder builder = new StringBuilder(s.length());
    for(char c:s.toCharArray()){
      if(c=='\n'){
        builder.append("\\n");
        continue;
      }
      if(c=='\t'){
        builder.append("\\t");
        continue;
      }
      if(c=='\\' || c == '"'){
        builder.append("\\");
      }
      builder.append(c);
    }
    return builder.toString();
  }

  public static String encodeSingle(String s) {

    StringBuilder builder = new StringBuilder(s.length());
    for(char c:s.toCharArray()){
      if(c=='\n'){
        builder.append("\\n");
        continue;
      }
      if(c=='\t'){
        builder.append("\\t");
        continue;
      }
      if(c=='\\' || c == '\''){
        builder.append("\\");
      }
      builder.append(c);
    }
    return builder.toString();
  }

  public void replaceParameters(Map<Object, Object> params) {
    if (value instanceof OInputParameter) {
      value = ((OInputParameter) value).bindFromInputParams(params);
    } else if (value instanceof OBaseExpression) {
      ((OBaseExpression) value).replaceParameters(params);
    } else if (value instanceof OParenthesisExpression) {
      ((OParenthesisExpression) value).replaceParameters(params);
    } else if (value instanceof OMathExpression) {
      ((OMathExpression) value).replaceParameters(params);
    }
  }

  public boolean supportsBasicCalculation() {
    if(value instanceof OMathExpression) {
      return ((OMathExpression)value).supportsBasicCalculation();
    }
    return true;
  }
}
/* JavaCC - OriginalChecksum=9c860224b121acdc89522ae97010be01 (do not edit this line) */
