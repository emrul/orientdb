/* Generated By:JJTree: Do not edit this line. OInstanceofCondition.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import com.orientechnologies.orient.core.db.record.OIdentifiable;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OInstanceofCondition extends OBooleanExpression {

  protected OExpression left;
  protected OIdentifier right;
  protected String      rightString;

  public OInstanceofCondition(int id) {
    super(id);
  }

  public OInstanceofCondition(OrientSql p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  @Override
  public boolean evaluate(OIdentifiable currentRecord) {
    return false;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(left.toString());
    builder.append(" instanceof ");
    if (right != null) {
      builder.append(right.toString());
    } else if (rightString != null) {
      builder.append(rightString);
    }
    return builder.toString();
  }

  @Override
  public void replaceParameters(Map<Object, Object> params) {
    left.replaceParameters(params);
  }

  @Override
  public boolean supportsBasicCalculation() {
    return left.supportsBasicCalculation();
  }

  @Override
  protected int getNumberOfExternalCalculations() {
    if (!left.supportsBasicCalculation()) {
      return 1;
    }
    return 0;
  }

  @Override
  protected List<Object> getExternalCalculationConditions() {
    if (!left.supportsBasicCalculation()) {
      return (List) Collections.singletonList(left);
    }
    return Collections.EMPTY_LIST;
  }

}
/* JavaCC - OriginalChecksum=0b5eb529744f307228faa6b26f0592dc (do not edit this line) */
