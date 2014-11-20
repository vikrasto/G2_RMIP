package keywords;

public class QueryToFetchDbData {

	public static String getRoomsSold(String PropertyName, String StartDate, String EndDate) throws Exception{
		 String query = "SELECT roomsSold FROM pmstotalinvtype a "
		    		+ "INNER JOIN propertyinventorytypes b ON a.PropertyinvtypeiD = b.PropertyinvtypeiD "
		    		+ "WHERE propertyID=(select propertyID from property where shortname='"+PropertyName+"') "
		    		+ "AND OccupancyDate BETWEEN '"+StartDate+"' AND '"+EndDate+"'";
		 return query;
	  }
	
	public static String getOccupancyForecast(String PropertyName, String StartDate, String EndDate) throws Exception{
		 String query = "SELECT SUM(occupancyforecast) FROM propertyforecasts "
		 		+ "WHERE propertyID=(select propertyID from property "
		 		+ "WHERE shortname='"+PropertyName+"') AND "
		 		+ "occupancyDate BETWEEN '"+StartDate+"' AND '"+EndDate+"' GROUP BY occupancyDate";
		 return query;
	  }
	
	public static String getOccupancyForecastPercentage(String PropertyName, String StartDate, String EndDate) throws Exception{
		 String query = "SELECT a.occupancyDate, occupancyForecast, roomCapacity, (occupancyForecast/roomCapacity)*100 AS occupancyForecastPer FROM (SELECT occupancyDate, SUM(occupancyForecast) AS occupancyForecast FROM propertyforecasts WHERE propertyID=(select propertyID from property WHERE shortname='"+PropertyName+"') AND occupancyDate BETWEEN '"+StartDate+"' AND '"+EndDate+"' GROUP BY occupancyDate) a INNER JOIN (SELECT occupancyDate, roomCapacity FROM pmstotalinvtype WHERE propertyInvTypeID=(SELECT propertyInvTypeID FROM propertyinventorytypes WHERE propertyID=(select propertyID from property WHERE shortname='"+PropertyName+"') AND shortname='ROH') AND occupancyDate BETWEEN '"+StartDate+"' AND '"+EndDate+"') b USING(occupancyDate)";
		 return query;
	  }
	
	public static String getLRVoverbookingAndBARValues(String PropertyName, String StartDate, String EndDate){
//		String query = "SELECT propertybardecisionsandoverrides.arrivaldate AS arrivaldate,b.spectrumType,propertybardecisionsandoverrides.propertyid AS propertyid,LRV_1,LRV_2,LRV_3,LRV_4,LRV_5,LRV_6,LRV_7,LRV_8,OverBooking,MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_2,MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_4, MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_8, MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN IF(webbardecision>0,bbbb.shortname,webbardecision) ELSE NULL END) AS webBarDecision_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN IF(webbardecision>0,bbbb.shortname,webbardecision) ELSE NULL END) AS webBarDecision_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN IF(webbardecision>0,bbbb.shortname,webbardecision) ELSE NULL END) AS webBarDecision_2, MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN IF(webbardecision>0,bbbb.shortname,webbardecision) ELSE NULL END) AS webBarDecision_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN IF(webbardecision>0,bbbb.shortname,webbardecision) ELSE NULL END) AS webBarDecision_4, MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN IF(webbardecision>0,bbbb.shortname,webbardecision)ELSE NULL END) AS webBarDecision_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN IF(webbardecision>0,bbbb.shortname,webbardecision)ELSE NULL END) AS webBarDecision_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN IF(webbardecision>0,bbbb.shortname,webbardecision) ELSE NULL END) AS webBarDecision_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN IF(webbardecision>0,bbbb.shortname,webbardecision) ELSE NULL END) AS webBarDecision_8, MIN(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN IF(finalBar>0,cccc.shortname,finalBar) ELSE NULL END) AS finalBar_0, MIN(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN IF(finalBar>0,cccc.shortname,finalBar) ELSE NULL END) AS finalBar_1, MIN(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN IF(finalBar>0,cccc.shortname,finalBar) ELSE NULL END) AS finalBar_2, MIN(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN IF(finalBar>0,cccc.shortname,finalBar) ELSE NULL END) AS finalBar_3, MIN(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN IF(finalBar>0,cccc.shortname,finalBar)ELSE NULL END) AS finalBar_4, MIN(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN IF(finalBar>0,cccc.shortname,finalBar) ELSE NULL END) AS finalBar_5, MIN(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN IF(finalBar>0,cccc.shortname,finalBar) ELSE NULL END) AS finalBar_6, MIN(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN IF(finalBar>0,cccc.shortname,finalBar) ELSE NULL END) AS finalBar_7, MIN(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN IF(finalBar>0,cccc.shortname,finalBar)ELSE NULL END) AS finalBar_8, MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_2, MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_4, MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_8, MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN systembarvalue ELSE NULL END) AS systembarvalue_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN systembarvalue ELSE NULL END) AS systembarvalue_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN systembarvalue ELSE NULL END) AS systembarvalue_2, MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN systembarvalue ELSE NULL END) AS systembarvalue_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN systembarvalue ELSE NULL END) AS systembarvalue_4, MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN systembarvalue ELSE NULL END) AS systembarvalue_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN systembarvalue ELSE NULL END) AS systembarvalue_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN systembarvalue ELSE NULL END) AS systembarvalue_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN systembarvalue ELSE NULL END) AS systembarvalue_8, MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN webbarvalue ELSE NULL END) AS webbarvalue_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN webbarvalue ELSE NULL END) AS webbarvalue_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN webbarvalue ELSE NULL END) AS webbarvalue_2, MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN webbarvalue ELSE NULL END) AS webbarvalue_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN webbarvalue ELSE NULL END) AS webbarvalue_4, MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN webbarvalue ELSE NULL END) AS webbarvalue_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN webbarvalue ELSE NULL END) AS webbarvalue_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN webbarvalue ELSE NULL END) AS webbarvalue_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN webbarvalue ELSE NULL END) AS webbarvalue_8, MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_2, MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_4,  MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_8, MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_2, MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_4,  MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_8, MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN isFloor ELSE NULL END) AS isFloor_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN isFloor ELSE NULL END) AS isFloor_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN isFloor ELSE NULL END) AS isFloor_2, MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN isFloor ELSE NULL END) AS isFloor_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN isFloor ELSE NULL END) AS isFloor_4,  MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN isFloor ELSE NULL END) AS isFloor_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN isFloor ELSE NULL END) AS isFloor_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN isFloor ELSE NULL END) AS isFloor_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN isFloor ELSE NULL END) AS isFloor_8 FROM propertybardecisionsandoverrides  LEFT OUTER JOIN propertybarrateplans AS bbbb ON propertybardecisionsandoverrides.propertyid=bbbb.PropertyId AND webBarDecision=bbbb.PropertyBarRatePlanId  LEFT OUTER JOIN propertybarrateplans AS aaaa ON propertybardecisionsandoverrides.propertyid=aaaa.PropertyId AND systemBarDecision = aaaa.PropertyBarRatePlanId  LEFT OUTER JOIN propertybarrateplans AS cccc ON propertybardecisionsandoverrides.propertyid=cccc.PropertyId AND finalBar=cccc.PropertyBarRatePlanId  LEFT OUTER JOIN propertybarrateplans AS dddd ON propertybardecisionsandoverrides.propertyid=dddd.PropertyId AND userBarOverride=dddd.PropertyBarRatePlanId LEFT OUTER JOIN (SELECT arrivaldate,propertybarratedetails.spectrumType,los, MAX(IF(propertyBarRatePlanID=systembardecision,VALUE,NULL)) AS systembarValue, MAX(IF(propertyBarRatePlanID=webbardecision,VALUE,NULL)) AS webbarvalue, MAX(IF(propertyBarRatePlanID=finalbar,VALUE,NULL)) AS finalbarvalue, MAX(IF(propertyBarRatePlanID=userBarOverride,VALUE,NULL)) AS userBarOverridevalue  FROM propertybardecisionsandoverrides INNER JOIN propertybarrateplans ON (propertybardecisionsandoverrides.finalBar=propertybarrateplans.propertyBarRatePlanID OR propertybardecisionsandoverrides.systemBarDecision = propertybarrateplans.propertyBarRatePlanID OR propertybardecisionsandoverrides.webBarDecision = propertybarrateplans.propertyBarRatePlanID OR propertybardecisionsandoverrides.userBarOverride = propertybarrateplans.propertyBarRatePlanID)LEFT OUTER JOIN propertybarratedetails USING (propertyBarRatePlanID) LEFT OUTER JOIN propertybarratedetailsbydow USING (barRateDetailsID) WHERE  arrivaldate BETWEEN propertybarratedetails.startDate AND propertybarratedetails.endDate AND DAYOFWEEK(arrivaldate)=dowid AND    propertybardecisionsandoverrides.propertyId=(select propertyID from property where shortname='"+PropertyName+"') AND arrivaldate BETWEEN '"+StartDate+"' AND '"+EndDate+"' GROUP BY los,arrivaldate ORDER BY los,arrivalDate) AS b ON b.arrivaldate =propertybardecisionsandoverrides.arrivaldate AND b.los=propertybardecisionsandoverrides.los LEFT OUTER JOIN (SELECT occupancydate AS dddate,cc.overbooking,cc.lambda AS LRV_0,cc.lambda AS LRV_1,(SELECT SUM(b.lambda)/2 FROM propertydecisions AS b WHERE b.occupancydate BETWEEN dddate AND DATE_ADD(dddate,INTERVAL 1 DAY) AND b.propertyid=cc.propertyid) AS LRV_2,(SELECT SUM(b.lambda)/3 FROM propertydecisions AS b WHERE b.occupancydate BETWEEN dddate AND DATE_ADD(dddate,INTERVAL 2 DAY) AND b.propertyid=cc.propertyid) AS LRV_3,(SELECT SUM(b.lambda)/4 FROM propertydecisions AS b WHERE b.occupancydate BETWEEN dddate AND DATE_ADD(dddate,INTERVAL 3 DAY) AND b.propertyid=cc.propertyid) AS LRV_4,(SELECT SUM(b.lambda)/5 FROM propertydecisions AS b WHERE b.occupancydate BETWEEN dddate AND DATE_ADD(dddate,INTERVAL 4 DAY) AND b.propertyid=cc.propertyid) AS LRV_5,(SELECT SUM(b.lambda)/6 FROM propertydecisions AS b WHERE b.occupancydate BETWEEN dddate AND DATE_ADD(dddate,INTERVAL 5 DAY) AND b.propertyid=cc.propertyid) AS LRV_6,(SELECT SUM(b.lambda)/7 FROM propertydecisions AS b WHERE b.occupancydate BETWEEN dddate AND DATE_ADD(dddate,INTERVAL 6 DAY) AND b.propertyid=cc.propertyid) AS LRV_7,(SELECT SUM(b.lambda)/8 FROM propertydecisions AS b WHERE b.occupancydate BETWEEN dddate AND DATE_ADD(dddate,INTERVAL 7 DAY) AND b.propertyid=cc.propertyid) AS LRV_8 FROM propertydecisions AS cc WHERE propertyid=(select propertyID from property where shortname='"+PropertyName+"') AND cc.occupancydate BETWEEN '"+StartDate+"' AND '"+EndDate+"') AS c ON c.dddate = propertybardecisionsandoverrides.arrivaldate  WHERE propertybardecisionsandoverrides.propertyid=(select propertyID from property where shortname='"+PropertyName+"') AND propertybardecisionsandoverrides.arrivaldate BETWEEN '"+StartDate+"' AND '"+EndDate+"' GROUP BY arrivalDate ORDER BY arrivalDate";
		String query = "SELECT propertybardecisionsandoverrides.arrivaldate AS arrivaldate,b.spectrumType,propertybardecisionsandoverrides.propertyid AS propertyid,LRV_1,LRV_2,LRV_3,LRV_4,LRV_5,LRV_6,LRV_7,LRV_8,OverBooking,MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_2,MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_4, MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN IF(systemBarDecision>0,aaaa.shortname,systemBarDecision) ELSE NULL END) AS systemBarDecision_8, MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN IF(webbardecision>0,bbbb.shortname,webbardecision) ELSE NULL END) AS webBarDecision_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN IF(webbardecision>0,bbbb.shortname,webbardecision) ELSE NULL END) AS webBarDecision_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN IF(webbardecision>0,bbbb.shortname,webbardecision) ELSE NULL END) AS webBarDecision_2, MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN IF(webbardecision>0,bbbb.shortname,webbardecision) ELSE NULL END) AS webBarDecision_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN IF(webbardecision>0,bbbb.shortname,webbardecision) ELSE NULL END) AS webBarDecision_4, MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN IF(webbardecision>0,bbbb.shortname,webbardecision)ELSE NULL END) AS webBarDecision_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN IF(webbardecision>0,bbbb.shortname,webbardecision)ELSE NULL END) AS webBarDecision_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN IF(webbardecision>0,bbbb.shortname,webbardecision) ELSE NULL END) AS webBarDecision_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN IF(webbardecision>0,bbbb.shortname,webbardecision) ELSE NULL END) AS webBarDecision_8, MIN(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN IF(finalBar>0,cccc.shortname,finalBar) ELSE NULL END) AS finalBar_0, MIN(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN IF(finalBar>0,cccc.shortname,finalBar) ELSE NULL END) AS finalBar_1, MIN(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN IF(finalBar>0,cccc.shortname,finalBar) ELSE NULL END) AS finalBar_2, MIN(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN IF(finalBar>0,cccc.shortname,finalBar) ELSE NULL END) AS finalBar_3, MIN(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN IF(finalBar>0,cccc.shortname,finalBar)ELSE NULL END) AS finalBar_4, MIN(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN IF(finalBar>0,cccc.shortname,finalBar) ELSE NULL END) AS finalBar_5, MIN(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN IF(finalBar>0,cccc.shortname,finalBar) ELSE NULL END) AS finalBar_6, MIN(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN IF(finalBar>0,cccc.shortname,finalBar) ELSE NULL END) AS finalBar_7, MIN(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN IF(finalBar>0,cccc.shortname,finalBar)ELSE NULL END) AS finalBar_8,MIN(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN IF(rmiBarDecision>0,eeee.shortname,rmiBarDecision) ELSE NULL END) AS reputationBar_0, MIN(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN IF(rmiBarDecision>0,eeee.shortname,rmiBarDecision) ELSE NULL END) AS reputationBar_1, MIN(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN IF(rmiBarDecision>0,eeee.shortname,rmiBarDecision) ELSE NULL END) AS reputationBar_2, MIN(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN IF(rmiBarDecision>0,eeee.shortname,rmiBarDecision) ELSE NULL END) AS reputationBar_3, MIN(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN IF(rmiBarDecision>0,eeee.shortname,rmiBarDecision)ELSE NULL END) AS reputationBar_4, MIN(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN IF(rmiBarDecision>0,eeee.shortname,rmiBarDecision) ELSE NULL END) AS reputationBar_5, MIN(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN IF(rmiBarDecision>0,eeee.shortname,rmiBarDecision) ELSE NULL END) AS reputationBar_6, MIN(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN IF(rmiBarDecision>0,eeee.shortname,rmiBarDecision) ELSE NULL END) AS reputationBar_7, MIN(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN IF(rmiBarDecision>0,eeee.shortname,rmiBarDecision)ELSE NULL END) AS reputationBar_8,MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_2, MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_4, MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN IF(userBarOverride>0,dddd.shortname,userBarOverride) ELSE NULL END) AS userBarOverride_8, MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN systembarvalue ELSE NULL END) AS systembarvalue_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN systembarvalue ELSE NULL END) AS systembarvalue_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN systembarvalue ELSE NULL END) AS systembarvalue_2, MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN systembarvalue ELSE NULL END) AS systembarvalue_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN systembarvalue ELSE NULL END) AS systembarvalue_4, MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN systembarvalue ELSE NULL END) AS systembarvalue_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN systembarvalue ELSE NULL END) AS systembarvalue_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN systembarvalue ELSE NULL END) AS systembarvalue_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN systembarvalue ELSE NULL END) AS systembarvalue_8, MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN webbarvalue ELSE NULL END) AS webbarvalue_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN webbarvalue ELSE NULL END) AS webbarvalue_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN webbarvalue ELSE NULL END) AS webbarvalue_2, MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN webbarvalue ELSE NULL END) AS webbarvalue_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN webbarvalue ELSE NULL END) AS webbarvalue_4, MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN webbarvalue ELSE NULL END) AS webbarvalue_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN webbarvalue ELSE NULL END) AS webbarvalue_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN webbarvalue ELSE NULL END) AS webbarvalue_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN webbarvalue ELSE NULL END) AS webbarvalue_8, MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_2, MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_4,  MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN finalbarvalue ELSE NULL END) AS finalbarvalue_8, MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_2, MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_4,  MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN userBarOverridevalue ELSE NULL END) AS userBarOverridevalue_8, MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN rmiBarvalue ELSE NULL END) AS reputationBarvalue_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN rmiBarvalue ELSE NULL END) AS reputationBarvalue_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN rmiBarvalue ELSE NULL END) AS reputationBarvalue_2, MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN rmiBarvalue ELSE NULL END) AS reputationBarvalue_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN rmiBarvalue ELSE NULL END) AS reputationBarvalue_4,  MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN rmiBarvalue ELSE NULL END) AS reputationBarvalue_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN rmiBarvalue ELSE NULL END) AS reputationBarvalue_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN rmiBarvalue ELSE NULL END) AS reputationBarvalue_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN rmiBarvalue ELSE NULL END) AS reputationBarvalue_8,MAX(CASE WHEN propertybardecisionsandoverrides.los = -1 THEN isFloor ELSE NULL END) AS isFloor_0, MAX(CASE WHEN propertybardecisionsandoverrides.los = 1 THEN isFloor ELSE NULL END) AS isFloor_1, MAX(CASE WHEN propertybardecisionsandoverrides.los = 2 THEN isFloor ELSE NULL END) AS isFloor_2, MAX(CASE WHEN propertybardecisionsandoverrides.los = 3 THEN isFloor ELSE NULL END) AS isFloor_3, MAX(CASE WHEN propertybardecisionsandoverrides.los = 4 THEN isFloor ELSE NULL END) AS isFloor_4,  MAX(CASE WHEN propertybardecisionsandoverrides.los = 5 THEN isFloor ELSE NULL END) AS isFloor_5, MAX(CASE WHEN propertybardecisionsandoverrides.los = 6 THEN isFloor ELSE NULL END) AS isFloor_6, MAX(CASE WHEN propertybardecisionsandoverrides.los = 7 THEN isFloor ELSE NULL END) AS isFloor_7, MAX(CASE WHEN propertybardecisionsandoverrides.los = 8 THEN isFloor ELSE NULL END) AS isFloor_8 FROM propertybardecisionsandoverrides  LEFT OUTER JOIN propertybarrateplans AS bbbb ON propertybardecisionsandoverrides.propertyid=bbbb.PropertyId AND webBarDecision=bbbb.PropertyBarRatePlanId  LEFT OUTER JOIN propertybarrateplans AS aaaa ON propertybardecisionsandoverrides.propertyid=aaaa.PropertyId AND systemBarDecision = aaaa.PropertyBarRatePlanId  LEFT OUTER JOIN propertybarrateplans AS cccc ON propertybardecisionsandoverrides.propertyid=cccc.PropertyId AND finalBar=cccc.PropertyBarRatePlanId  LEFT OUTER JOIN propertybarrateplans AS dddd ON propertybardecisionsandoverrides.propertyid=dddd.PropertyId AND userBarOverride=dddd.PropertyBarRatePlanId LEFT OUTER JOIN propertybarrateplans AS eeee ON propertybardecisionsandoverrides.propertyid=eeee.PropertyId AND rmiBarDecision=eeee.PropertyBarRatePlanId LEFT OUTER JOIN(SELECT arrivaldate,propertybarratedetails.spectrumType,los, MAX(IF(propertyBarRatePlanID=systembardecision,VALUE,NULL)) AS systembarValue, MAX(IF(propertyBarRatePlanID=webbardecision,VALUE,NULL)) AS webbarvalue, MAX(IF(propertyBarRatePlanID=finalbar,VALUE,NULL)) AS finalbarvalue, MAX(IF(propertyBarRatePlanID=userBarOverride,VALUE,NULL)) AS userBarOverridevalue,  MAX(IF(propertyBarRatePlanID=rmiBarDecision,VALUE,NULL)) AS rmiBarvalue  FROM propertybardecisionsandoverrides INNER JOIN propertybarrateplans ON (propertybardecisionsandoverrides.finalBar=propertybarrateplans.propertyBarRatePlanID OR propertybardecisionsandoverrides.systemBarDecision = propertybarrateplans.propertyBarRatePlanID OR propertybardecisionsandoverrides.webBarDecision = propertybarrateplans.propertyBarRatePlanID OR propertybardecisionsandoverrides.userBarOverride = propertybarrateplans.propertyBarRatePlanID OR propertybardecisionsandoverrides.rmiBarDecision = propertybarrateplans.propertyBarRatePlanID)LEFT OUTER JOIN propertybarratedetails USING (propertyBarRatePlanID) LEFT OUTER JOIN propertybarratedetailsbydow USING (barRateDetailsID) WHERE  arrivaldate BETWEEN propertybarratedetails.startDate AND propertybarratedetails.endDate AND DAYOFWEEK(arrivaldate)=dowid AND    propertybardecisionsandoverrides.propertyId=(select propertyID from property where shortname='"+PropertyName+"') AND arrivaldate BETWEEN '"+StartDate+"' AND '"+EndDate+"' GROUP BY los,arrivaldate ORDER BY los,arrivalDate) AS b ON b.arrivaldate =propertybardecisionsandoverrides.arrivaldate AND b.los=propertybardecisionsandoverrides.los LEFT OUTER JOIN (SELECT occupancydate AS dddate,cc.overbooking,cc.lambda AS LRV_0,cc.lambda AS LRV_1,(SELECT SUM(b.lambda)/2 FROM propertydecisions AS b WHERE b.occupancydate BETWEEN dddate AND DATE_ADD(dddate,INTERVAL 1 DAY) AND b.propertyid=cc.propertyid) AS LRV_2,(SELECT SUM(b.lambda)/3 FROM propertydecisions AS b WHERE b.occupancydate BETWEEN dddate AND DATE_ADD(dddate,INTERVAL 2 DAY) AND b.propertyid=cc.propertyid) AS LRV_3,(SELECT SUM(b.lambda)/4 FROM propertydecisions AS b WHERE b.occupancydate BETWEEN dddate AND DATE_ADD(dddate,INTERVAL 3 DAY) AND b.propertyid=cc.propertyid) AS LRV_4,(SELECT SUM(b.lambda)/5 FROM propertydecisions AS b WHERE b.occupancydate BETWEEN dddate AND DATE_ADD(dddate,INTERVAL 4 DAY) AND b.propertyid=cc.propertyid) AS LRV_5,(SELECT SUM(b.lambda)/6 FROM propertydecisions AS b WHERE b.occupancydate BETWEEN dddate AND DATE_ADD(dddate,INTERVAL 5 DAY) AND b.propertyid=cc.propertyid) AS LRV_6,(SELECT SUM(b.lambda)/7 FROM propertydecisions AS b WHERE b.occupancydate BETWEEN dddate AND DATE_ADD(dddate,INTERVAL 6 DAY) AND b.propertyid=cc.propertyid) AS LRV_7,(SELECT SUM(b.lambda)/8 FROM propertydecisions AS b WHERE b.occupancydate BETWEEN dddate AND DATE_ADD(dddate,INTERVAL 7 DAY) AND b.propertyid=cc.propertyid) AS LRV_8 FROM propertydecisions AS cc WHERE propertyid=(select propertyID from property where shortname='"+PropertyName+"') AND cc.occupancydate BETWEEN '"+StartDate+"' AND '"+EndDate+"') AS c ON c.dddate = propertybardecisionsandoverrides.arrivaldate  WHERE propertybardecisionsandoverrides.propertyid=(select propertyID from property where shortname='"+PropertyName+"') AND propertybardecisionsandoverrides.arrivaldate BETWEEN '"+StartDate+"' AND '"+EndDate+"' GROUP BY arrivalDate ORDER BY arrivalDate";
		return query;
	}
	
	public static String getSpecialEventsByAllDates(String PropertyName, String StartDate, String EndDate){
		String 	query = "SELECT a.Datee AS DATE , GROUP_CONCAT(shortName ORDER BY shortName SEPARATOR ', ') AS SpecialEvents FROM (SELECT CONVERT(CONVERT('"+EndDate+"',DATE) - INTERVAL (a.a + (10 * b.a) + (100 * c.a)) DAY,DATE) AS DATEE FROM (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS a CROSS JOIN (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS b CROSS JOIN (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS c ) a LEFT OUTER JOIN propertyspecialevents b ON datee>=b.startdate AND b.endDate>=a.Datee LEFT OUTER JOIN propertySpecialEventTypes c ON b.propertySpecialEventTypeID = c.propertySpecialEventTypeID AND propertyid IN(SELECT propertyID FROM property WHERE shortname='"+PropertyName+"') AND impactsForecast='Y' WHERE Datee BETWEEN '"+StartDate+"' AND '"+EndDate+"' GROUP BY datee ORDER BY Datee ";
		return query;
	}
	
	public static String getSpecialEvents(String PropertyName, String StartDate, String EndDate){
		String query = "SELECT a.Date AS DATE ,GROUP_CONCAT(description ORDER BY shortname SEPARATOR ', ') AS SpecialEventDescription,GROUP_CONCAT(shortname ORDER BY shortname SEPARATOR ', ') AS SpecialEvents FROM (SELECT CONVERT(CONVERT(@occupancyEnddate,DATE) - INTERVAL (a.a + (10 * b.a) + (100 * c.a)) DAY,DATE) AS DATE FROM (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS a CROSS JOIN (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS b CROSS JOIN (SELECT 0 AS a UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS c ) a, propertyspecialevents  INNER JOIN propertySpecialEventTypes USING(propertySpecialEventTypeID) WHERE propertyid=(SELECT propertyID FROM property WHERE shortname='"+PropertyName+"') AND impactsForecast='Y' AND endDate>=a.Date AND Startdate <=a.Date AND a.Date BETWEEN '"+StartDate+"' AND '"+StartDate+"' GROUP BY a.date ORDER BY a.Date";
		return query;
	}
	
	public static String getRoomsSoldLastYearToDate(String PropertyName, String StartDate, String EndDate, String GUISystemToday){
		String query = "SELECT DOW_ADJUSTED_NEXT_YEAR_DATE(T.occupancydate) AS occupancydate,SUM(p.roomssold) AS LastYrSoldToDate  FROM pmstotalinvtypemarketpace p,(SELECT usageType, businesstypeid,propertyinvtypeid,occupancyDate,propertymarketid,MAX(capturedate)AS capturedate FROM pmstotalinvtypemarketpace JOIN propertymarkets USING(propertymarketid) JOIN propertymarketgroups USING(propertymarketgroupid) WHERE propertyinvtypeid = (SELECT PropertyInvTypeID FROM propertyinventorytypes WHERE propertyid IN (SELECT propertyID FROM property WHERE shortname='"+PropertyName+"') AND shortname = 'ROH') AND capturedate<= DOW_ADJUSTED_LAST_YEAR_DATE('"+GUISystemToday+"') AND occupancydate BETWEEN DOW_ADJUSTED_LAST_YEAR_DATE('"+StartDate+"') AND DOW_ADJUSTED_LAST_YEAR_DATE('"+EndDate+"') GROUP BY propertyinvtypeid,occupancyDate,propertymarketid)T WHERE p. propertyinvtypeid=t.propertyinvtypeid AND p.capturedate=T.capturedate AND p.occupancyDate=T.occupancyDate AND p.propertymarketid= T.propertymarketid GROUP BY occupancydate";
		return query;
	}
	public static String getBARoutputType(String PropertyName){
		String query = "SELECT value FROM propertysystemparameters WHERE propertyID=(select propertyID from property where shortname='"+PropertyName+"') AND propertyparamvariable='BAR_OUTPUT_TYPE'";
		return query;
	}
}
