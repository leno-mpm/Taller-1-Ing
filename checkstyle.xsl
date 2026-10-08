<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" encoding="UTF-8"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Checkstyle Initial Report</title>
            </head>
            <body>
                <h1>Checkstyle - Initial Report</h1>

                <p>
                    Total violations:
                    <xsl:value-of select="count(//error)"/>
                </p>

                <table border="1" cellpadding="8">
                    <tr>
                        <th>Line</th>
                        <th>Severity</th>
                        <th>Message</th>
                    </tr>

                    <xsl:for-each select="//error">
                        <tr>
                            <td><xsl:value-of select="@line"/></td>
                            <td><xsl:value-of select="@severity"/></td>
                            <td><xsl:value-of select="@message"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>