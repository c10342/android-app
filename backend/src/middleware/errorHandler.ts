import { NextFunction, Request, Response } from 'express';
import { HttpError } from '../types';

// 404 处理中间件
export const notFoundHandler = (req: Request, _res: Response, next: NextFunction): void => {
  const error = new HttpError(404, `路径不存在: ${req.originalUrl}`);
  next(error);
};

// 全局错误处理中间件（必须保留 4 个参数，Express 才能识别为错误处理函数）
export const errorHandler = (
  err: HttpError,
  _req: Request,
  res: Response,
  _next: NextFunction
): void => {
  const statusCode = err.statusCode || 500;
  const message = err.message || '服务器内部错误';

  res.status(statusCode).json({
    code: statusCode,
    message,
  });
};
