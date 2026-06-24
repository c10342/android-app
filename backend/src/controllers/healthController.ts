import { Request, Response } from 'express';
import { ApiResponse } from '../types';

// 健康检查
export const healthCheck = (_req: Request, res: Response): void => {
  const response: ApiResponse = {
    code: 200,
    message: '服务运行正常',
  };
  res.status(200).json(response);
};
