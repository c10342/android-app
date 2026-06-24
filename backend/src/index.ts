import express, { Request, Response } from 'express';
import cors from 'cors';
import helmet from 'helmet';
import config from './config';
import { requestLogger } from './middleware/requestLogger';
import { errorHandler, notFoundHandler } from './middleware/errorHandler';
import authRoutes from './routes/authRoutes';
import healthRoutes from './routes/healthRoutes';
import { ApiResponse } from './types';

const app = express();

// 基础中间件
app.use(helmet());
app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(requestLogger);

// 路由
app.use('/api/health', healthRoutes);
app.use('/api/auth', authRoutes);

// 根路由
app.get('/', (_req: Request, res: Response) => {
  const response: ApiResponse = {
    code: 200,
    message: 'Express + TypeScript 服务已启动',
  };
  res.status(200).json(response);
});

// 404 与错误处理（必须放在所有路由之后）
app.use(notFoundHandler);
app.use(errorHandler);

// 启动服务
app.listen(config.port,config.host, () => {
  console.log(`🚀 服务已启动: http://${config.host}:${config.port}`);
  console.log(`   环境: ${config.nodeEnv}`);
});

export default app;
