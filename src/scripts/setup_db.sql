USE [master]
GO
CREATE LOGIN [spring] WITH PASSWORD=N'password', DEFAULT_DATABASE=[HydroContainers], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO

USE [HydroContainers]
GO
CREATE USER [spring] FOR LOGIN [spring]
GO
USE [HydroContainers]
GO
ALTER USER [spring] WITH DEFAULT_SCHEMA=[dbo]
GO
USE [HydroContainers]
GO
ALTER ROLE [db_owner] ADD MEMBER [spring]
GO



-- SQL SRV: sqlsrv-intern-dev-wus3-001
-- SQL DB:  sqldb-intern-dev-wus3-001
-- User:    internadmin
-- Pass:    P455w0rd