<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="xml" indent="yes"/>
<xsl:template match="/">

<html>
<head>
<title>VAQProfilPersonal In Action</title>
</head>
<body style="background:#f5f5f5">
<p>VAQProfi In Action </p>
<p>Personal Information</p>
<center> 
<h1 style="background-color: #ffa500">Personal Information</h1>
<img src="utrgv-var(1).png" alt="UTRGV" style="width: 100px; height: 100px"> </img>
 </center> 

<p>Personal Information</p>
<table align="center" border="0">
<tr>
<th>First Name</th>
<th>Last Name</th>
</tr>
<xsl:for-each select="PersonalInformation/PersonalComponent">
<tr>
<td class="center"><xsl:value-of select="firstname"/></td>
<td class="center"><xsl:value-of select="lastname"/></td>
</tr>
</xsl:for-each>
<tr>
<th>Address</th>
<th>City</th>
<th>State</th>
</tr>
<xsl:for-each select="PersonalInformation/PersonalComponent">
<tr>
<td class="center"><xsl:value-of select="address"/></td>
<td class="center"><xsl:value-of select="city"/></td>
<td class="center"><xsl:value-of select="state"/></td>
</tr>
</xsl:for-each>
<tr>
<th>Email</th>
<th>Age</th>
<th>Sex</th>
</tr>
<xsl:for-each select="PersonalInformation/PersonalComponent">
<tr>
<td class="center"><xsl:value-of select="email"/></td>
<td class="center"><xsl:value-of select="age"/></td>
<td class="center"><xsl:value-of select="sex"/></td>
</tr>
</xsl:for-each>
</table>
</body></html>
</xsl:template>
</xsl:stylesheet>