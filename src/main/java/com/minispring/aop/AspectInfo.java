package com.minispring.aop;


import com.minispring.aop.aspect.DefaultAspect;
import lombok.Data;

@Data
public class AspectInfo {
  private int             orderIndex;
  private DefaultAspect   aspectObject;
  //复用AspectJ
  private PointCutLocator pointCutLocator;
  public AspectInfo() {

  }

  public AspectInfo(int orderIndex, DefaultAspect aspectObject) {
    this.orderIndex = orderIndex;
    this.aspectObject = aspectObject;
  }

  public AspectInfo(int orderIndex, DefaultAspect aspectObject, PointCutLocator pointCutLocator) {
    this.orderIndex = orderIndex;
    this.aspectObject = aspectObject;
    this.pointCutLocator = pointCutLocator;
  }
}